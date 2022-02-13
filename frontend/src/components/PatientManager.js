import React, {useEffect, useState} from 'react';
import '../css/home.css'
import 'admin-lte/dist/css/adminlte.min.css'
import avatar from '../images/user-avatar-thumb.png';
import ImageResize from "./ImageResize";
import PatientService from "../services/PatientService";
import '../css/patient.css'

const PatientManager = (props) => {
    const initPatient = {
        patient: {
            id: "",
            name: "",
            age: "",
            gender: "",
            status: "",
            injection: "",
            birthDate: "",
            discoveryDay: "",
            address: "",
            iconPath: "F:\\WORK\\covid\\src\\main\\frontend\\src\\images\\user-avatar-thumb.png",
        }
    }
    const [patient, setPatient] = useState(initPatient);
    const [listPatient, setListPatient] = useState(undefined);
    const [image, setImage] = useState(null);

    useEffect(() => {
            PatientService.getAll()
                .then(response => {
                    setListPatient(response.data)
                })
                .catch((error) => {
                    console.log(error.message);
                })

        }
        , []);

    const savePatient = () => {
        if (window.confirm('Add the patient?')) {
            console.log(patient)
            PatientService.create(patient)
                .then(response => {
                    console.log(response.data);
                })
                .catch(error => {
                    console.log(error);
                });
        }
    };
    const handleChange = event => {
        const {name, value} = event.target;
        console.log(name + " value " + value)
        setPatient({...patient, [name]: value});
    }

    const handleChangeImage = async (event) => {
        const file = event.target.files[0];
        const base64 = await convertBase64(file);
        setImage(base64);
        const {name} = event.target;
        setPatient({...patient, [name]: base64});
    };


    const convertBase64 = (file) => {
        return new Promise((resolve, reject) => {
            const fileReader = new FileReader();
            fileReader.readAsDataURL(file);

            fileReader.onload = () => {
                resolve(fileReader.result);
            };
            fileReader.onerror = (error) => {
                reject(error);
            };
        });
    };

    const updatePatient = (patientId) => {
        console.log(patientId)
        PatientService.update(
            patientId
        )
            .then(response => {
                console.log(response.data);
                this.setState({
                    message: "The patient was updated successfully!"
                });
            })
    }
    return (
        <div>
            <div className="card card-info ">
                <div className="card-header titleHeader">
                    <h3 className="card-title">Patient manager</h3>
                </div>
                <form className="form-horizontal">
                    <div className="card-body carBodyUpdate ">
                        <div className={"row"}>
                            <div className={"col-md-9"}>
                                <div className="form-group row">
                                    <label htmlFor="inputEmail3"
                                           className="col-md-2 col-form-label textCenter">Name</label>
                                    <div className="col-md-7">
                                        <input onChange={handleChange} name="name" type="email" className="form-control"
                                               id="inputEmail3"
                                        />
                                    </div>
                                </div>
                                <div className="form-group row">
                                    <label
                                        className="col-md-2 col-form-label textCenter">Age</label>
                                    <div className="col-md-7">
                                        <input onChange={handleChange} name="age" type="number" className="form-control"
                                        />
                                    </div>
                                </div>
                                <div className="form-group row">
                                    <label
                                        className="col-md-2 col-form-label textCenter">Gender</label>
                                    <div className="col-md-3">
                                        <div className="form-check">
                                            <input className="form-check-input" onChange={handleChange} type="radio"
                                                   value={"Male"}
                                                   name="gender"/>
                                            <label className="form-check-label">Male</label>
                                        </div>
                                    </div>
                                    <div className="col-md-4">
                                        <div className="form-check">
                                            <input className="form-check-input" onChange={handleChange} type="radio"
                                                   value={"Female"}
                                                   name="gender"/>
                                            <label className="form-check-label">Female</label>
                                        </div>
                                    </div>

                                </div>
                                <div className="form-group row">
                                    <label
                                        className="col-md-2 col-form-label textCenter">Birthday</label>
                                    <div className="col-md-7">
                                        <input type="date" className="form-control" onChange={handleChange}
                                               name="birthday"
                                        />
                                    </div>
                                </div>
                                <div className="form-group row">
                                    <label
                                        className="col-md-2 col-form-label textCenter">Discovery day</label>
                                    <div className="col-md-7">
                                        <input type="date" className="form-control" onChange={handleChange}
                                               name="discoveryDay"
                                        />
                                    </div>
                                </div>
                                <div className="form-group row">
                                    <label
                                        className="col-md-2 col-form-label textCenter">Status</label>
                                    <div className="col-md-7">
                                        <input type="text" className="form-control" onChange={handleChange}
                                               name="status"
                                        />
                                    </div>
                                </div>
                                <div className="form-group row">
                                    <label
                                        className="col-md-2 col-form-label textCenter">Injection time</label>
                                    <div className="col-md-7">
                                        <input type="number" className="form-control" onChange={handleChange}
                                               name="injectTime"
                                        />
                                    </div>
                                </div>
                                <div className="form-group row">
                                    <label
                                        className="col-md-2 col-form-label textCenter">Address</label>
                                    <div className="col-md-7">
                                        <input type="textarea" className="form-control" onChange={handleChange}
                                               name="address"
                                        />
                                    </div>
                                </div>
                            </div>
                            <div className="col-md-3">
                                <div className={"form-group row"}>
                                    <img src={image} width="400" height="400"/>
                                    <input type="file"
                                           className="text-center center-block file-upload"
                                           name="iconPath"
                                           onChange={handleChangeImage}
                                    />
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                <div className="card-footer">
                    <button className=" buttonAction add" onClick={savePatient}>Add</button>
                    <button className=" buttonAction update">Update</button>
                    <button className=" buttonAction delete">Delete</button>
                    <button className=" buttonAction detail">Detail</button>
                </div>
                <table id="example" className="table table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Gender</th>
                        <th>Status</th>
                        <th>Inject time</th>
                        <th>Birthday</th>
                        <th>Discovery day</th>
                        <th>Address</th>
                        <th>Image</th>
                        <th>Control</th>
                    </tr>
                    </thead>
                    <tbody>
                    {listPatient &&
                    listPatient.map((patient) => (
                            <tr key={patient.id}>
                                <td>{patient.id}</td>
                                <td>{patient.name}</td>
                                <td>{patient.age}</td>
                                <td>{patient.gender}</td>
                                <td>{patient.status}</td>
                                <td>{patient.injectTime}</td>
                                <td>{patient.birthday}</td>
                                <td>{patient.discoveryDay}</td>
                                <td>
                                    <p className="textResize">{patient.address}</p></td>
                                <td>
                                    <p className="textResize">{patient.iconPath}</p>
                                </td>
                                <td><a className="btn btn-warning" onClick={updatePatient(patient.id)}>Update</a>
                                    <a className="btn btn-primary">Delete</a></td>
                            </tr>
                        )
                    )}
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default PatientManager;