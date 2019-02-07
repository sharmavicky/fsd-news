import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private service: LoginService) { }

  ngOnInit() {
  }
  user: any;
  email: any;
  getUser(email) {
    this.service.getUser(email).subscribe(data => {
      console.log(data)
      this.user = data;
    })
  }
  changeStatus(email) {
    this.service.changeStatus(email).subscribe(data => {
      console.log(data);
      this.user = data;
      console.log(this.user.blacklist);

    })
  }

}
