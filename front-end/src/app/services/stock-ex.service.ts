import { Injectable } from '@angular/core';
import { ApiServiceService } from './api-service.service';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StockExService {

  constructor(private apiService: ApiServiceService) { }

  getAllExchanges(){
    let list:BehaviorSubject<any> = new BehaviorSubject<any>([]);
    this.apiService.get('company-service/exchange/all').subscribe(data=>{
      console.log(data);
      list.next(data);
    })
    return list;
  }
}
