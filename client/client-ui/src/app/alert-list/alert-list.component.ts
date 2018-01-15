import { Component} from '@angular/core';
import {AlertsService} from '../alert-service/alerts.service';

@Component({
  selector: 'app-alert-list',
  templateUrl: './alert-list.component.html',
  styleUrls: ['./alert-list.component.css']
})
export class AlertListComponent {
  alerts;
  constructor(private alertService: AlertsService) {
    this.alertService.getAllAlerts()
      .subscribe(
        alerts => this.alerts = alerts,
        error => console.log(error)
      );
  }
}

