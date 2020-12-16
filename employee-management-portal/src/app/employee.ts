export class Employee{
    
    constructor(
        public id:number,
        public firstName:String,
        public middleName:String,
        public lastName:String,
        public emailAddress:String,
        public phoneNumber:String,
        public permanentAddress:String,
        public correspondenceAddress:String,
        public dateOfBirth:String,
        public joiningDate:String,
        public releivingDate:String,
        public gender:String,
        public department:{
            id:number
        },
        public designation:{
            id:number
        },
        public manager:{
            id:number
        }){
    }
}