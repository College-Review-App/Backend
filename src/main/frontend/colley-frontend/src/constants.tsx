const prod = {
    url: {
        API_URL: '',
    },
}

const dev = {
    url: {
        API_URL: 'http://localhost:8080'
    },
}

// <!-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDemJ99w4cxTRcQ30T2RC_zDLREzC5csWM&libraries=places"></script> -->

export const config = process.env.NODE_ENV === 'development' ? dev : prod;