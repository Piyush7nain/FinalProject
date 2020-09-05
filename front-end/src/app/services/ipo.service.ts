import { Injectable } from '@angular/core';
import { ApiServiceService } from './api-service.service';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IpoService {

  constructor(private apiService: ApiServiceService) { }
  baseUrl:string ="company-service/ipo/";

  getAllIpoByCompanyName(name:string):Observable<any>{
    let list:BehaviorSubject<any> = new BehaviorSubject<any>([]);
    this.apiService.get(this.baseUrl+"company/"+name+"/all").subscribe(data=>{
      console.log(data);
      list.next(data)
    })
    return list;
  }

  getAllIpoByStockCode(code:string):Observable<any>{
    let list:BehaviorSubject<any> = new BehaviorSubject<any>([]);
    this.apiService.get("company-service/exchange/"+code+"/ipos").subscribe(data=>{
      console.log(data);
      list.next(data)
    })
    return list;
  }
  
  addIpo(obj: any, name:string):Observable<any>{
    let status:BehaviorSubject<any> = new BehaviorSubject<any>([]);
    this.apiService.post(this.baseUrl+"add/"+name , obj).subscribe(data=>{
      console.log(data);
      status.next(data)
    });
    return status;
  }

  removeIpo(id:number){
    this.apiService.get(this.baseUrl+"remove/"+ id).subscribe(date=>{
      console.log(date);
    })
  }

}
