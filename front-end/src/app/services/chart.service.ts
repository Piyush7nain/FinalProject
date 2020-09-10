import { Injectable } from '@angular/core';
import { ChartData } from '../models/ChartData';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChartService {

  constructor() { }
  dataSource:ChartData[]=new Array();

  updateChartData(data:ChartData[]){
    this.dataSource = data;
  }

  getChartData():Observable<ChartData[]>{
    let data:BehaviorSubject<ChartData[]> = new BehaviorSubject<ChartData[]>([])
    data.next(this.dataSource);
    console.log("updated chart data => ", data);
    return data;
  }
}
