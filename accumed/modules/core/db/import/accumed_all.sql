-- Facility codes
insert into ops.accumed_facility (id, create_ts, created_by, version, update_Ts, updated_by, delete_ts, deleted_by,
facility_code, facility_name)
select uuid_generate_v4(), now(), 'admin', 1, now(), 'admin', null, null, facilitynum, description
from ops.lz_faccodes


-- Patients
-- Patients
INSERT INTO ops.accumed_patient(
            id, legacy_id, create_ts, created_by, delete_ts, deleted_by, update_ts, 
            updated_by, version, notes, response, member_number, version_code, 
            expired_on, first_name, middle_name, last_name, birth_date, gender, 
            email, address_line1, address_line2, postal_code, home_phone, 
            work_phone, cell_phone,  family_doctor_id,  
            hn_check_date, hl7_patient_id, city, province, country)
    SELECT uuid_generate_v4(), patientid, now(),'admin', null, null, now(), 
            'admin', 1, notes, response, healthnum, versioncode, 
            expyear, p.fname, null, p.lname, dob, sex, 
            null, p.address, null, p.postalcode, hphone, 
            wphone, null,  d.id, hncheckdate,   
            hl7patid, p.city, p.province, p.country
    FROM ops.lz_patient p
    left outer join ops.accumed_provider d on d.provider_id = p.famdoc 
    WHERE sex in ('M','F');


	
--Specialties
INSERT INTO ops.accumed_speciality(
            id, create_ts, created_by, version, update_ts, updated_by, delete_ts, 
            deleted_by, specialty_code, specialty_name)
select uuid_generate_v4(), now(), 'admin', 1, now(), 'admin', null, null, speccode, description
from ops.lz_speccodes


INSERT INTO ops.accumed_provider(
            id, create_ts, created_by, version, update_ts, updated_by, delete_ts, 
            deleted_by, provider_id, title, first_name, last_name, middle_name, 
            email, address_line1, address_line2, city, province, postal_code, 
            work_phone, fax_number, group_number, primary_specialty_id, country, 
            ministry_of_health_office)
    SELECT uuid_generate_v4(), now(), 'admin', 1, now(), 'admin', null, 
            null, providernum, case when length(title)<5 then title else '' END, fname, lname, null, 
            email, address, null, city, province, postalcode, 
            phone, fax, cast(groupnum as varchar(10)), s.id, country, 
            mohoffice
    from ops.lz_doctors d
    left outer join ops.accumed_speciality s 
    on s.specialty_code = d.speccode;


	
INSERT INTO ops.accumed_facility(
            id, create_ts, created_by, version, update_ts, updated_by, delete_ts, 
            deleted_by, facility_code, facility_name)
select uuid_generate_v4(), now(), 'admin', 1, now(), 'admin', null, null, facilitynum, 'Unknown'
from (
select distinct facilitynum from ops.lz_patient
except
select facilitynum from ops.lz_faccodes) x
where x.facilitynum is not null;


INSERT INTO ops.accumed_patient_admission(
            id, create_ts, created_by, version, update_ts, updated_by, delete_ts, 
            deleted_by, admit_date, patient_id, facility_id)
select uuid_generate_v4(), now(), 'admin', 1, now(), 'admin', null, null, admitdate, t.id as pat_id, f.id as fac_id 
from ops.lz_patient p
inner join ops.accumed_patient t
on t.legacy_id = p.patientid
left outer join ops.accumed_facility f
on f.facility_code = p.facilitynum
where facilitynum is not null and p.admitdate is not null;