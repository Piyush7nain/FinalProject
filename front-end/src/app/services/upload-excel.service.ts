import { Injectable } from '@angular/core';
import { ApiServiceService } from './api-service.service';
import { BehaviorSubject, Observable } from 'rxjs';
import { UploadSummary } from '../models/UploadSummary'

@Injectable({
  providedIn: 'root'
})
export class UploadExcelService {

  constructor(private apiService: ApiServiceService) { }

  fileUpload(file: any): Observable<any> {
    let fileUploadSubject: BehaviorSubject<any> = new BehaviorSubject<any>([]);
    const formData = new FormData();
    formData.append('file', file, file.name);
    this.apiService.postFiles("upload-service/upload/excel",formData).subscribe(data =>{
      console.log(data);
      fileUploadSubject.next(data);
    });
    return fileUploadSubject;
  }
}
