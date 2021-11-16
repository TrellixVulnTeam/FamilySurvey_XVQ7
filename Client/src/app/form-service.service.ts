import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, } from '@angular/common/http';
import { Observable } from 'rxjs';
// import { Form } from './form';
// import { Survey } from './survey';

@Injectable({
  providedIn: 'root'
})
export class FormServiceService {

  owner: any; //for owner data
  modals= [];
  verify = false;
  url = "http://localhost:8080/survey";

  constructor(private http:HttpClient) { }

  saveData(user: any): Observable<any>{
    return this.http.post('http://localhost:8080/auth/register', user, {responseType: 'text'});
  }

  getData(user: any): Observable<any>{
    return this.http.post('http://localhost:8080/auth/login', user,{responseType: 'text'});
  }

  saveServayData(survey: any): Observable<any>{
    return this.http.post('http://localhost:8080/survey/save', survey, {responseType: 'text'});
  }

  updateSurveyData(survey: any): Observable<any>{
    return this.http.put('http://localhost:8080/survey/update', survey, {responseType: 'text'});
  }

  showData(): Observable<any>{
    return this.http.get('http://localhost:8080/survey/showData');
  }

  deleteMember(id: number): Observable<any>{
    return this.http.delete(`${this.url}/deleteMember/${id}`,{responseType: 'text'});
  }

  resetPassword(data: any): Observable<any>{
    return this.http.post('http://localhost:8080/auth/forgot-password', data)
  }

  //collect data from edit button
  takeOwner(data: any): Observable<any>{
    this.owner = data.rowData; 
    this.verify = true;
    return this.owner;
  }

}


