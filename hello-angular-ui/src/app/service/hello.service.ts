import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class HelloService {

  constructor(private http: HttpClient) {

  }

  hello(input: string) {
    return this.http.get(`${environment.helloApi}?name= + ${input}`);
  }
}
