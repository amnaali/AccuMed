-- Facility codes
insert into ops.accumed_facility (id, create_ts, created_by, version, update_Ts, updated_by, delete_ts, deleted_by,
facility_code, facility_name)
select uuid_generate_v4(), now(), 'admin', 1, now(), 'admin', null, null, facilitynum, description
from ops.lz_faccodes


-- Patients
INSERT INTO ops.accumed_patient(
            id, create_ts, created_by, delete_ts, deleted_by, update_ts, 
            updated_by, version, notes, response, member_number, version_code, 
            expired_on, first_name, middle_name, last_name, birth_date, gender, 
            email, address_line1, address_line2, postal_code, home_phone, 
            work_phone, cell_phone, referring_doctor, family_doctor, facility_number, 
            admit_date, hn_check_date, hl7_patient_id, city, province, country)
    SELECT uuid_generate_v4(), now(),'admin', null, null, now(), 
            'admin', 1, notes, response, healthnum, versioncode, 
            expyear, fname, null, lname, dob, sex, 
            null, address, null, postalcode, hphone, 
            wphone, null, refdoc, famdoc, facilitynum, 
            admitdate, hncheckdate, hl7patid, city, province, country
    FROM ops.lz_patient
    WHERE sex in ('M','F')

	
--Specialties
INSERT INTO ops.accumed_speciality(
            id, create_ts, created_by, version, update_ts, updated_by, delete_ts, 
            deleted_by, specialty_code, specialty_name)
select uuid_generate_v4(), now(), 'admin', 1, now(), 'admin', null, null, speccode, description
from ops.lz_speccodes


