import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AgmCoreModule } from '@agm/core';
import { AppComponent } from './app.component';
import {VehicleServiceService} from './vehicle-service/vehicle-service.service';
import {VehicleListComponent} from './vehicle-list/vehicle-list.component';
import {RouterModule, Routes} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import { VehicleDetailsComponent } from './vehicle-details/vehicle-details.component';
import { ReadingListComponent } from './reading-list/reading-list.component';
import {ReadingsService} from './reading-service/readings.service';
import { AlertListComponent } from './alert-list/alert-list.component';
import { LocalMapsComponent } from './local-maps/local-maps.component';
import { ReadingGraphsComponent } from './reading-graphs/reading-graphs.component';
import {ChartsModule} from "ng2-charts";
import {AlertsService} from "./alert-service/alerts.service";


const appRoutes: Routes = [
  {path: 'vehicles' , component: VehicleListComponent},
  {path: 'vehicles/:id' , component: VehicleDetailsComponent},
  {path: 'vehicles/:id/geoloaction/:id', component: LocalMapsComponent},
  {path: 'vehicles/graphs/:id', component: ReadingGraphsComponent},
  {path: 'vehicles/:id/alerts/:id', component: AlertListComponent},
  {path: 'vehicles/:id/readings/:id', component: ReadingListComponent},
  {path: '', redirectTo: '/vehicles', pathMatch: 'full'}
  ];

@NgModule({
  declarations: [
    AppComponent,
    VehicleListComponent,
    VehicleDetailsComponent,
    ReadingListComponent,
    AlertListComponent,
    LocalMapsComponent,
    ReadingGraphsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    ChartsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyBlaLlyfG-8aDQ1JgnRmSG3WN6oxE6dGzU'
    })
  ],
  providers: [VehicleServiceService, ReadingsService, AlertsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
