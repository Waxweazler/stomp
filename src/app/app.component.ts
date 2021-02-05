import {Component, OnDestroy} from '@angular/core';
import {WebSocketService} from './websocket.service';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html'
})
export class AppComponent implements OnDestroy {

    log: string;

    constructor(private webSocketService: WebSocketService) {
    }

    connect(): void {
        this.webSocketService.connect('ws://localhost:4200/sim-statistics/ws');
    }

    watch(): void {
        this.webSocketService.watch('/log/statistic').subscribe(message => {
            this.log = message.body;
        });
    }

    ngOnDestroy(): void {
        this.webSocketService.disconnect();
    }

}
