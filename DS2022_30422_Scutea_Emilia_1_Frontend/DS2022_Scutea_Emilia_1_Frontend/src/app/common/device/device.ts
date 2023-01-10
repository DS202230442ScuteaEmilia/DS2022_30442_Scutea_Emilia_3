export class Device {
    constructor(public id: number,
                public address: string,
                public description: string,
                public user_id: number,
                public maxHourlyEnergyCons: number
    ){ }
}
