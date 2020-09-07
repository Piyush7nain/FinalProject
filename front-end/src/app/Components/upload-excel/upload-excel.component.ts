import { Component, OnInit, ElementRef } from '@angular/core';

import { UploadSummary } from '../../models/UploadSummary'
import { UploadExcelService } from 'src/app/services/upload-excel.service';

@Component({
  selector: 'app-upload-excel',
  templateUrl: './upload-excel.component.html',
  styleUrls: ['./upload-excel.component.css']
})
export class UploadExcelComponent implements OnInit {

  constructor(private el: ElementRef, private uploadService: UploadExcelService) { }
  uploadSummary: UploadSummary;
  showSummary:boolean = false;
  showMessage:boolean = false;

  message:string;
  ngOnInit() {
    // this.showMessage = false;
    // this.showSummary = false;
  }

  uploadExcel() {

    let t_files: any = this.el.nativeElement.querySelector('#file').files[0];
    this.uploadService.fileUpload(t_files).subscribe(data => {
        if(data.status =="successful"){
          this.showMessage = true
          this.showSummary = true;
          this.uploadSummary = data;
        }
    });
  }

}
