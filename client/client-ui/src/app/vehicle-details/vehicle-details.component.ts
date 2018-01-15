import { Component } from '@angular/core';
import {VehicleServiceService} from '../vehicle-service/vehicle-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-vehicle-details',
  templateUrl: './vehicle-details.component.html',
  styleUrls: ['./vehicle-details.component.css']
})
export class VehicleDetailsComponent {
  vehicle;
  constructor(private route: ActivatedRoute, vehicleServiceService: VehicleServiceService) {
    // this.vehicleServiceService.getVehiclebyVin()
    //   .subscribe(
    //     vehicle => this.vehicle = vehicle,
    //     error => console.log(error)
    //   );
    //

    this.route.params.subscribe(params => {
      vehicleServiceService.getVehiclebyVin(params.id)
        .subscribe(vehicle => this.vehicle = vehicle);
    });
  }
}
