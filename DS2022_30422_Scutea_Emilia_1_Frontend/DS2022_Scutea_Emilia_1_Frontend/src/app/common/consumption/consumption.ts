export class Consumption {
    constructor(public id: number,
                public device_id: number,
                public timestamp: Date,
                public consumption: number) {}
}
