import http from "../commons/http-common";
class UserService {
    doLogin(data) {
        return http.post("/user/do-login", data);
    }
}
export default new UserService();