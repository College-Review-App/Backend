class applicantProfile {
    private profileId: number;
    // Not returned by profile interface
    private collegeId: number;
    private profileDate: Date;
    // Not returned by profile interface
    private city: String;
    private state: String;
    private country: String;
    private ethnicity: String;
    private classOf: number;
    private firstGen: Boolean;
    private legacyStudent: Boolean;
    private gender: number;
    private familyIncome: number;
    private GPA: number;
    private SAT: number;
    private ACT: number;
    private intendedMajor: String;
    private extracurriculars: String;
    private advice: String;
    private outcome: number;
        
    constructor(applicantReview: Object) {
        this.profileId = this.setOrNull(Object(applicantReview)["profileId"]);
        this.collegeId = this.setOrNull(Object(applicantReview)["collegeId"]);
        this.profileDate = this.setOrNull(Object(applicantReview)["profileDate"]);
        this.city = this.setOrNull(Object(applicantReview)["city"]);
        this.state = this.setOrNull(Object(applicantReview)["state"]);
        this.country = this.setOrNull(Object(applicantReview)["country"]);
        this.ethnicity = this.setOrNull(Object(applicantReview)["ethnicity"]);
        this.classOf = this.setOrNull(Object(applicantReview)["classOf"]);
        this.firstGen = this.setOrNull(Object(applicantReview)["firstGen"]);
        this.legacyStudent = this.setOrNull(Object(applicantReview)["legacyStudent"]);
        this.gender = this.setOrNull(Object(applicantReview)["gender"]);
        this.familyIncome = this.setOrNull(Object(applicantReview)["familyIncome"]);
        this.GPA = this.setOrNull(Object(applicantReview)["gpa"]);
        this.SAT = this.setOrNull(Object(applicantReview)["sat"]);
        this.ACT = this.setOrNull(Object(applicantReview)["act"]);
        this.intendedMajor = this.setOrNull(Object(applicantReview)["intendedMajor"]);
        this.extracurriculars = this.setOrNull(Object(applicantReview)["extracurriculars"]);
        this.advice = this.setOrNull(Object(applicantReview)["advice"]);
        this.outcome = this.setOrNull(Object(applicantReview)["outcome"]);
    }

    private setOrNull(reviewField: any): any {
        return reviewField == null || reviewField == undefined ? null : reviewField
    }

    public get getProfileId(): number {
        return this.profileId;
    }

    public get getCollegeId(): number {
        return this.collegeId;
    }

    public get getProfileDate(): Date {
        return this.profileDate;
    }

    public get getCity(): String {
        return this.city;
    }

    public get getState(): String {
        return this.state;
    }

    public get getCountry(): String {
        return this.country;
    }

    public get getEthnicity(): String {
        return this.ethnicity;
    }

    public get getClassOf(): number {
        return this.classOf;
    }

    public get getFirstGen(): Boolean {
        return this.firstGen;
    }

    public get getLegacyStudent(): Boolean {
        return this.legacyStudent;
    }

    public get getGender(): number {
        return this.gender;
    }

    public get getFamilyIncome(): number {
        return this.familyIncome;
    }

    public get getGPA(): number {
        return this.GPA;
    }

    public get getSAT(): number {
        return this.SAT;
    }

    public get getACT(): number {
        return this.ACT;
    }

    public get getIntendedMajor(): String {
        return this.intendedMajor;
    }

    public get getExtracurriculars(): String {
        return this.extracurriculars;
    }

    public get getAdvice(): String {
        return this.advice;
    }

    public get getOutcome(): number {
        return this.outcome;
    }

}

export default applicantProfile