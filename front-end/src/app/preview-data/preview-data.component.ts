import { Component, OnInit, Input } from '@angular/core';
import { DragAndDropService } from '../../service/dragDrop.service';

@Component({
  selector: 'app-preview-data',
  templateUrl: './preview-data.component.html',
  styleUrls: ['./preview-data.component.css']
})
export class PreviewDataComponent implements OnInit {
  previewData : any ;
  @Input('selectedCols') selectedCols: string[];
  @Input('finalQuery') finalQuery: string;
  @Input('nameFile') nameFile: string;
  show = 0 ;
  constructor(public dragdropService:DragAndDropService) { }

  ngOnInit() {

    this.dragdropService.getSelectQuery(this.nameFile, this.finalQuery).subscribe((data : any)=>{
      this.previewData = data;
      console.log(this.previewData);
    })
  }

}
