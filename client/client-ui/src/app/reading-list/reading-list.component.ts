import { Component } from '@angular/core';
import {ReadingsService} from "../reading-service/readings.service";

@Component({
  selector: 'app-reading-list',
  templateUrl: './reading-list.component.html',
  styleUrls: ['./reading-list.component.css']
})
export class ReadingListComponent {
  readings;
  constructor(private readingService: ReadingsService) {
    this.readingService.getReadings()
      .subscribe(
        readings => this.readings = readings,
        error => console.log(error)
      );
  }
}
