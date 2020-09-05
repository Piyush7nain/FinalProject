import { Injectable } from '@angular/core';
import { ApiServiceService } from './api-service.service';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CompanyServiceService {

  constructor(private apiService: ApiServiceService) { }

  addNewCompany(obj:any):Observable<any>{
    let status:BehaviorSubject<string> = new BehaviorSubject<string>('');
    this.apiService.post("company-service/company/addCompany", obj).subscribe(data =>{
      console.log(data);
      status.next(data.status);
    })
    return status;
  }

  getAll():Observable<any>{
    let list:BehaviorSubject<any> = new BehaviorSubject<any>([]);
    this.apiService.get("company-service/company/all").subscribe(data =>{
      console.log(data);
      list.next(data);
    })
    return list;
  }

  getByLikeName(name:any):Observable<any>{
    let list:BehaviorSubject<any> = new BehaviorSubject<any>([]);
    this.apiService.get("company-service/company/like/"+ name).subscribe(data =>{
      console.log(data);
      list.next(data);
    })
    return list;
  }
  getByName(name:any):Observable<any>{
    let list:BehaviorSubject<any> = new BehaviorSubject<any>([]);
    this.apiService.get("company-service/company/"+ name).subscribe(data =>{
      console.log(data);
      list.next(data);
    })
    return list;
  }

  updateCompany(obj:any):Observable<any>{
    let status:BehaviorSubject<string> = new BehaviorSubject<string>('');
    this.apiService.post("company-service/company/updateCompany", obj).subscribe(data =>{
      console.log(data);
      status.next(data.status);
    })
    return status;
  }
}
