import { Component } from '@angular/core';
import {VehicleServiceService} from '../vehicle-service/vehicle-service.service';

@Component({
  selector: 'app-vehicle-details',
  templateUrl: './vehicle-details.component.html',
  styleUrls: ['./vehicle-details.component.css']
})
export class VehicleDetailsComponent {
  vehicle;
  constructor(private vehicleServiceService: VehicleServiceService) {
    this.vehicleServiceService.getVehiclebyVin()
      .subscribe(
        vehicle => this.vehicle = vehicle,
        error => console.log(error)
      );
  }
}
