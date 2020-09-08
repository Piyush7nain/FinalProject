import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StorageService } from '../../services/storage.service';

@Component({
  selector: 'app-user-navbar',
  templateUrl: './user-navbar.component.html',
  styleUrls: ['./user-navbar.component.css']
})
export class UserNavbarComponent implements OnInit {

  constructor(private router: Router,
    private storageService: StorageService) { }

  ngOnInit(): void {
  }

  onLogout(){
    this.storageService.removeUserInfo();
    this.router.navigate(['login']);
  }

}
