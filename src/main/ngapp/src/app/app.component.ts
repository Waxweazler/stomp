import {Component, OnDestroy} from '@angular/core';
import {WebSocketService} from './websocket.service';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnDestroy {

    messageHistory: string[] = [];

    constructor(private webSocketService: WebSocketService) {
    }

    connect(): void {
        this.webSocketService.connect('ws://localhost:8080/ws').then(() => {
            this.webSocketService.watch('/topic/list').subscribe(message => {
                this.messageHistory.push(message.body);
            });
        });
    }

    disconnect(): void {
        this.webSocketService.disconnect().then(() => {
            this.messageHistory = [];
        });
    }

    connected(): boolean {
        return this.webSocketService.connected();
    }

    ngOnDestroy(): void {
        this.disconnect();
    }

}
