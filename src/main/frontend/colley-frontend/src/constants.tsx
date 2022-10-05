const prod = {
    analytics: true,
    url: {
        API_URL: '',
    },
}

const dev = {
    analytics: false,
    url: {
        API_URL: 'http://localhost:8080'
    },
}

export const config = process.env.NODE_ENV === 'development' ? dev : prod;