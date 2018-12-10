import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from "@angular/common/http";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {ButtonModule} from 'primeng/button';
import {ScrollPanelModule} from 'primeng/scrollpanel';
import {ScrollDispatchModule} from '@angular/cdk/scrolling';
import { ScrollingModule } from '@angular/cdk/scrolling';
/*import {DragDropModule} from 'primeng/dragdrop';*/
import {ListboxModule} from 'primeng/listbox';
import { DragAndDropComponent } from './drag-and-drop/drag-and-drop.component';
import {DragDropModule} from '@angular/cdk/drag-drop';
import { DragAndDropService } from '../service/dragDrop.service';
import { SelectionComponent } from './selection/selection.component';
import { RouterModule, Routes } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatCheckboxModule} from '@angular/material';
import { PreviewDataComponent } from './preview-data/preview-data.component'

const appRoutes:Routes = [
  { path: 'select' ,component: SelectionComponent},
  { path: 'previewData' ,component: PreviewDataComponent},
  {
    path: '' ,
    redirectTo: '',
    pathMatch:'full'
  }
]

@NgModule({
  declarations: [
    AppComponent,
    DragAndDropComponent,
    SelectionComponent,
    PreviewDataComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ButtonModule,
    ScrollPanelModule,
    DragDropModule,
    ScrollDispatchModule,
    ScrollingModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    ListboxModule,
    FormsModule,
    BrowserAnimationsModule,
    MatCheckboxModule,
  ],
  providers: [DragAndDropService],
  bootstrap: [AppComponent]
})
export class AppModule { }
