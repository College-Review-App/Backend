import React from 'react'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import CollegeHomePage from './screens/CollegePage/CollegeHomePage'
import Error404 from './screens/ErrorPage/Error404'
import HomePage from './screens/HomePage/HomePage'
import Footer from './components/FooterComponent/footer'
import Header from './components/HeaderComponent/header'
import AboutPage from './screens/AboutPage/AboutPage'
import FAQPage from './screens/FAQPage/FAQPage'
import BlogPage from './screens/BlogPage/BlogPage'
import AddCollegePage from './screens/AddCollegePage/AddCollegePage'

//headquarters for all things navigation and routing
//use links for navigation
//useNavigate

const RouterHQ: React.VFC = () => {
    return (
        <Router>

            <Header onClick={() => window.scrollTo(0,0)}/>

            <Routes>
                <Route path="/" element={<HomePage/>}/>
                <Route path="/colleges/:collegeName" element={<CollegeHomePage/>}/>
                <Route path="/about" element={<AboutPage/>}/>
                <Route path="/blog" element={<BlogPage/>}/>
                <Route path="/faq" element={<FAQPage/>}/>
                <Route path="/add-college" element={<AddCollegePage/>}/>
                <Route path="*" element={<Error404/>} />
            </Routes>

            <Footer />

        </Router>
    )
}

export default RouterHQ