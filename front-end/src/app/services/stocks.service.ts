import { Injectable } from '@angular/core';
import { ApiServiceService } from './api-service.service';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StocksService {

  constructor(private apiService: ApiServiceService) { }

  getAllStocksByStockCode(code:string):Observable<any>{
    let list:BehaviorSubject<any> = new BehaviorSubject<any>([]);
    this.apiService.get("company-service/exchange/"+code+"/stocks").subscribe(data=>{
      console.log(data);
      list.next(data)
    })
    return list;
  }

  getAllStocksByCompanyName(name:string):Observable<any>{
    let list:BehaviorSubject<any> = new BehaviorSubject<any>([]);
    this.apiService.get("company-service/stocks/company/"+name+"/all").subscribe(data=>{
      console.log(data);
      list.next(data)
    })
    return list;
  }

  getByCompanyNameAndRange(name:string, obj:any):Observable<any>{
    let list:BehaviorSubject<any> = new BehaviorSubject<any>([]);
    this.apiService.post("company-service/stocks/company/"+name+"/range", obj).subscribe(data=>{
      console.log(data);
      list.next(data)
    })
    return list;
  }

  addOneStock(obj:any, name:string):Observable<any>{
    let status:BehaviorSubject<any> = new BehaviorSubject<any>([]);
    this.apiService.post("company-service/stocks/add/"+name, obj).subscribe(data =>{
      console.log(data)
      status.next(data);
    })
    return status;
  }

  removeById(id:number):Observable<any>{
    let status:BehaviorSubject<any>= new BehaviorSubject<any>([]);
    this.apiService.get("company-service/stocks/remove/"+id).subscribe(data=>{
      console.log(data);
      status.next(data);
    })
    return status;
  }
}
