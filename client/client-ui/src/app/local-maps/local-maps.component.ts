import { Component } from '@angular/core';
import {ReadingsService} from '../reading-service/readings.service';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-local-maps',
  templateUrl: './local-maps.component.html',
  styleUrls: ['./local-maps.component.css']
})
export class LocalMapsComponent {
  readings;
  lat = 51.678418;
  lng = 7.809007;
  constructor(private route: ActivatedRoute, readingService: ReadingsService) {
    this.route.params.subscribe(params => {
      readingService.getReadingsByVin(params.id)
        .subscribe(
          readings => this.readings = readings,
          error => console.log(error));
    });
  }
}
