import {Component, OnInit} from '@angular/core';
import {HelloService} from "../service/hello.service";

@Component({
  selector: 'app-hello',
  templateUrl: './hello.component.html',
  styleUrls: ['./hello.component.css']
})
export class HelloComponent implements OnInit {

  name: string = '';
  resp: any;

  constructor(private helloService: HelloService) {
  }

  ngOnInit(): void {

  }

  submitReq() {

    const obs = this.helloService.hello(this.name);

    obs.subscribe(data => {
      this.resp = data;
    });


  }

}
