import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/filter';


@Injectable()
export class VehicleServiceService {

  constructor(private  http: HttpClient) { }

  // GET the full list of vehicles
  getVehicles(): Observable<any[]> {
    return this.http.get('/assets/vehicle.json')
      .map(response => response)
      .catch(error => Observable.throw(error.statusText));
  }

  // GET the details of single vehicle
  getVehiclebyVin(vin): Observable<any> {
    console.log(vin);
    return this.http.get('/assets/vehicle.json')
      .map(response => response)
      .catch(error => Observable.throw(error.statusText));
  }
}
