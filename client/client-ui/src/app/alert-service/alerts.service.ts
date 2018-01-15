import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class AlertsService {

  constructor(private http: HttpClient) { }
  getAllAlerts(): Observable<any[]> {
    return this.http.get(`http://localhost:8080/api/alerts`)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
}
