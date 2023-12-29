import { Routes } from '@angular/router';
import {MainComponent} from "./components/main/main.component";

export const routes: Routes = [

  {
    path: 'main',
    component: MainComponent,
    pathMatch: 'full'

  }


];
