import http from "../commons/http-common";
class PatientService{
    getAll(){
        return http.post("/patient/list")
    }

    get(id){
        return http.get(`/patient/${id}`);
    }

    create(data){
        return http.post("/patient/add",data);
    }

    update(data){
        return http.post("/patient/update",data);
    }

    delete(id){
        return http.delete(`/patient/delete/${id}`)
    }

    search(name,status){
        return http.get(`/patients?name=${name}&status=${status}`);
    }

    exportExcel(){
        return http.get("/patients/export");
    }

    exportDocx2(id){
        return http.get(`export/${id}`);
    }


}

export default new PatientService();