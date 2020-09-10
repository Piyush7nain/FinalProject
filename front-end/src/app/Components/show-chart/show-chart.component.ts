import { Component, OnInit, Input } from '@angular/core';
import * as FusionCharts from 'fusioncharts';

@Component({
  selector: 'app-show-chart',
  templateUrl: './show-chart.component.html',
  styleUrls: ['./show-chart.component.css']
})
export class ShowChartComponent implements OnInit {

  constructor() {}

  ngOnInit(): void {
    this.dataSource = {
      data: null,
      caption: {
        text: 'STOCKS COMPARISON'
      },
      yAxis: [
        {
          plot: {
            value: 'currentPrice',
            type: 'column'
          },
          format: {
            prefix: '$'
          },
          title: 'Stocks'
        }
      ],
      series:"companyName"
    };
    this.assignData();
  }

  @Input()
  data:any
  schema = [
    {
      "name":"companyName",
      "type":"string"
    },{
      "name":"currentPrice",
      "type":"number"
    },{
      "name":"date",
      "type":"date",
      "format":"%-d/%-m/%Y"
    }
  ]
  dataSource:any
  width:"100%";
  height:700;
  type:string ='timeseries';

  assignData(){
    let fusiontable = new FusionCharts.DataStore().createDataTable( this.data, this.schema);
    this.dataSource.data =fusiontable;
  }

  check(){
    console.log(this.data);
  }


}
