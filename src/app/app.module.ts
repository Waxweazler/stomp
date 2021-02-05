import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {RxStompService} from '@stomp/ng2-stompjs';

@NgModule({
    declarations: [AppComponent],
    imports: [BrowserModule],
    providers: [RxStompService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
