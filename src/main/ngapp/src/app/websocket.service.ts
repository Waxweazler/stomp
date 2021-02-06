import {Injectable} from '@angular/core';
import {RxStompService} from '@stomp/ng2-stompjs';
import {Message} from '@stomp/stompjs';
import {Observable} from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class WebSocketService {

    constructor(private stompService: RxStompService) {
    }

    connect(brokerURL): Promise<void> {
        return new Promise<void>(resolve => {
            this.stompService.configure({
                brokerURL
            });
            this.stompService.activate();
            resolve();
        });

    }

    disconnect(): Promise<void> {
        return this.stompService.deactivate();
    }

    watch(destination: string): Observable<Message> {
        return this.stompService.watch({
            destination, subscribeOnlyOnce: true
        });
    }

    connected(): boolean {
        return this.stompService.connected();
    }

}
