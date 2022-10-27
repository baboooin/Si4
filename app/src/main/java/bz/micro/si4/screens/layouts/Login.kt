package bz.micro.si4.screens.layouts

const val loginLayoutPortrait = """ { 
    UserPhoto: {
    start: ['parent', 'start', 30],
    top: ['parent', 'top', 50], 
    bottom: ['PasswordEdt', 'top', 70], 
},

   ChangeUser: {
    start: ['UserPhoto', 'start', 0],
    top: ['UserPhoto', 'top', 0], 
    bottom: ['UserPhoto','bottom', 0]
},

 Hello: {
    start: ['UserPhoto', 'start', 10],
    top: ['UserPhoto', 'bottom', 15], 
},

UserName: {
    start: ['Hello', 'end', 10],
    top: ['Hello', 'top', 0], 
},

LoginEdt:{
    start: ['parent', 'start', 50],
    bottom: ['PasswordEdt', 'top', 0],
    top: ['parent', 'top', 50],
    end: ['parent', 'end', 50],
},

LoginErr:{
    start: ['LoginEdt', 'start', 5],
    top: ['LoginEdt', 'bottom', 10]
},

PasswordEdt:{
    start: ['parent', 'start', 50],
    bottom: ['Center', 'top', 0],
    end: ['parent', 'end', 50],
},

PasswordErr:{
    start: ['PasswordEdt', 'start', 5],
    top: ['PasswordEdt', 'bottom', 10]
},

Center:{
 top: ['parent', 'top', 0],
 bottom: ['parent', 'bottom', 50]
},

Shield:{
    start: ['parent', 'start', 50],
    top: ['Center', 'bottom', 50],
    bottom: ['QRcode', 'top', 0] 
},

ShieldText:{
    start: ['Shield', 'end', 20],
    top: ['Shield', 'top', 0],
    bottom: ['Shield', 'bottom', 0]
}

QRcode:{
    start: ['parent', 'start', 50],
    top: ['Shield', 'bottom', 0],
    bottom: ['PhoneCall', 'bottom', 0]
},

QRcodeText:{
    start: ['QRcode', 'end', 20],
    top: ['QRcode', 'top', 0],
    bottom: ['QRcode', 'bottom', 0]
},


PhoneCall:{
    start: ['parent', 'start', 50],
    top: ['QRcode', 'bottom', 0],
    bottom: ['parent', 'bottom', 50]
    
},

PhoneCallText:{
    start: ['PhoneCall', 'end', 20],
    top: ['PhoneCall', 'top', 0],
    bottom: ['PhoneCall', 'bottom', 0]
},
}
 """




const val loginLayoutLandscape = """ { 
    UserPhoto: {
    start: ['parent', 'start', 30],
    top: ['parent', 'top', 50], 
    bottom: ['PasswordEdt', 'top', 70], 
},

   ChangeUser: {
    start: ['UserPhoto', 'start', 0],
    top: ['UserPhoto', 'top', 0], 
    bottom: ['UserPhoto','bottom', 0]
},

 Hello: {
    start: ['UserPhoto', 'start', 10],
    top: ['UserPhoto', 'bottom', 15], 
},

UserName: {
    start: ['Hello', 'end', 10],
    top: ['Hello', 'top', 0], 
},

LoginEdt:{
    start: ['parent', 'start', 50],
    bottom: ['PasswordEdt', 'top', 0],
    top: ['parent', 'top', 50],
    end: ['parent', 'end', 50],
},

LoginErr:{
    start: ['LoginEdt', 'start', 5],
    top: ['LoginEdt', 'bottom', 10]
},

PasswordEdt:{
    start: ['parent', 'start', 50],
    bottom: ['Center', 'top', 50],
    end: ['parent', 'end', 50],
},

PasswordErr:{
    start: ['PasswordEdt', 'start', 0],
    top: ['PasswordEdt', 'bottom', 5],
    bottom: ['Center', 'top', 0],
    
},

Center:{
 top: ['parent', 'top', 250],
 bottom: ['parent', 'bottom', 0]
},

Shield:{
    start: ['ShieldText', 'start', 0],
    end: ['ShieldText', 'end', 0],
    bottom: ['ShieldText', 'top', 5] 
},

ShieldText:{
    start: ['parent', 'start', 50],
    end: ['QRcodeText', 'start', 10],
    bottom: ['parent', 'bottom', 5]
}

QRcode:{
    start: ['QRcodeText', 'start', 0],
    end: ['QRcodeText', 'end', 0],
    bottom: ['QRcodeText', 'top', 5]
},

QRcodeText:{
    start: ['ShieldText', 'end', 10],
    end: ['PhoneCallText', 'start', 10],
    bottom: ['parent', 'bottom', 5]
},


PhoneCall:{
    start: ['PhoneCallText', 'start', 0],
     end: ['PhoneCallText', 'end', 0],
    bottom: ['PhoneCallText', 'top', 5]
    
},

PhoneCallText:{
    start: ['QRcodeText', 'end', 10],
    end: ['parent', 'end', 50],
    bottom: ['parent', 'bottom', 5]
},
}
 """
