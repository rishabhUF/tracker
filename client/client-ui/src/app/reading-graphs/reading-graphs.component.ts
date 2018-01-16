import {Component} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Reading} from './readings.model';
import {ReadingsService} from '../reading-service/readings.service';

@Component({
  selector: 'app-reading-graphs',
  templateUrl: './reading-graphs.component.html',
  styleUrls: ['./reading-graphs.component.css']
})
export class ReadingGraphsComponent {

  readings;
  signal: String;
  vinNumber: String;
  readingsArr: Reading[] = [];
  timeStamps: String[] = ['DAYS', 'HOURS', 'MINUTES'];
  timeNumber = 5;


  constructor(private readingService: ReadingsService) {
    this.readingService.getReadings()
      .subscribe(
        readings => this.readings = readings,
        error => console.log(error)
      );
  }

  public lineChartReadingData: Array<any> = [
    {data: [], label: 'Speed'},
    {data: [], label: 'Engine RPM'},
    {data: [], label: 'Engine Hp'},
    {data: [], label: 'Fuel Volume'}
  ];

  public lineChartTimeStampLabels: Array<any> = [0 , 2, 4, 6, 8, 10, 12];

  public lineChartOptions: any = {
    responsive: true
  };
  public lineChartColors: Array<any> = [
    { // grey
      backgroundColor: 'rgba(148,159,177,0.2)',
      borderColor: 'rgba(148,159,177,1)',
      pointBackgroundColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'
    },
    { // dark grey
      backgroundColor: 'rgba(77,83,96,0.2)',
      borderColor: 'rgba(77,83,96,1)',
      pointBackgroundColor: 'rgba(77,83,96,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(77,83,96,1)'
    },
    { // grey
      backgroundColor: 'rgba(148,159,177,0.2)',
      borderColor: 'rgba(148,159,177,1)',
      pointBackgroundColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'
    }
  ];
  public lineChartLegend = true;
  public lineChartType = 'line';

  public randomize(): void {
    const _lineChartData: Array<any> = new Array(this.lineChartReadingData.length);
    for (let i = 0; i < this.lineChartReadingData.length; i++) {
      _lineChartData[i] = {data: new Array(this.lineChartReadingData[i].data.length), label: this.lineChartReadingData[i].label};
      for (let j = 0; j < this.lineChartTimeStampLabels[i].data.length; j++) {
        _lineChartData[i].data[j] = Math.floor((Math.random() * 100) + 1);
      }
    }
    this.lineChartTimeStampLabels = _lineChartData;
  }

  // events
  public chartClicked(e: any): void {
    console.log(e);
  }

  public chartHovered(e: any): void {
    console.log(e);
  }

}
