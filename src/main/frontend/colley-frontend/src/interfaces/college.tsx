class college {
    private collegeId: number;
    private collegeName: String;
    private location: String;
    private image: String;
    private acceptanceRate: number;
    private ranking: number;
        
    constructor(college?: Object) {
        this.collegeId = this.setOrNull(Object(college)["collegeId"]);
        this.collegeName = this.setOrNull(Object(college)["collegeName"]);
        this.location = this.setOrNull(Object(college)["location"]);
        this.image = this.setOrNull(Object(college)["image"]);
        this.acceptanceRate = this.setOrNull(Object(college)["acceptanceRate"]);
        this.ranking = this.setOrNull(Object(college)["ranking"]);
    }

    private setOrNull(reviewField: any): any {
        return reviewField == null || reviewField == undefined ? null : reviewField
    }

    public get getCollegeId(): number {
        return this.collegeId;
    }

    public get getCollegeName(): String {
        return this.collegeName;
    }

    public get getLocation(): String {
        return this.location;
    }

    public get getImage(): String {
        return this.image;
    }

    public get getAcceptanceRate(): number {
        return this.acceptanceRate;
    }

    public get getRanking(): number {
        return this.ranking;
    }

}

export default college