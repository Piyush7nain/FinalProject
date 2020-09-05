import { Injectable } from '@angular/core';
import { ApiServiceService } from './api-service.service';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StockExService {

  constructor(private apiService: ApiServiceService) { }

  baseUrl ="company-service/exchange/"
  getAllExchanges(){
    let list:BehaviorSubject<any> = new BehaviorSubject<any>([]);
    this.apiService.get(this.baseUrl+ '/all').subscribe(data=>{
      console.log(data);
      list.next(data);
    })
    return list;
  }

  addStock(obj:any):Observable<any>{
    let status:BehaviorSubject<any> = new BehaviorSubject<any>([]);
    this.apiService.post(this.baseUrl +"/addUpdateExchange", obj).subscribe(data =>{
      console.log(data);
      status.next(data)
    })
    return status;
  }
}
