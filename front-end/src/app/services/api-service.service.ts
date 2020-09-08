import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse, HttpRequest, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {

  private baseUrl:String = "http://localhost:8888/";
  constructor(private http: HttpClient) {  }

  get( url:string, urlParams?:HttpParams):Observable<any>{
    return this.http.get(this.baseUrl + url, { headers: this.getHeaders(), params: urlParams });
  }
  post(url: string, body: any): Observable<any> {
    return this.http.post(this.baseUrl + url, body, { headers: this.getHeaders() });
  }


  getHeaders(): HttpHeaders {
    let headers = new HttpHeaders();
    headers = headers.append('Content-Type', 'application/json');
    return headers;
  }

  postFiles( url:string,formData: FormData):Observable<any>{
    return this.http.post(this.baseUrl +url, formData)
  }

}
