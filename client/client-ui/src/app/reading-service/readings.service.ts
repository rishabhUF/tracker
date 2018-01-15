import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class ReadingsService {

  constructor(private http: HttpClient) {}

  getReadings(): Observable<any[]> {
    return this.http.get('assets/readings.json')
      .map(response => response)
      .catch(error => Observable.throw(error.statusText));
  }
}
