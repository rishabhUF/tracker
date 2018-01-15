import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {VehicleServiceService} from './vehicle-service/vehicle-service.service';
import {VehicleListComponent} from './vehicle-list/vehicle-list.component';
import {RouterModule, Routes} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import { VehicleDetailsComponent } from './vehicle-details/vehicle-details.component';



const appRoutes: Routes = [
  {path: 'vehicles' , component: VehicleListComponent},
  {path: 'vehicles/:id' , component: VehicleDetailsComponent},
  // {path: 'alerts' , component: },
  {path: '', redirectTo: '/vehicles', pathMatch: 'full'}
  ];

@NgModule({
  declarations: [
    AppComponent,
    VehicleListComponent,
    VehicleDetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [VehicleServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
