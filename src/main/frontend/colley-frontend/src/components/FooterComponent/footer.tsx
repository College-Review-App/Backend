import React from 'react';

// Import for the footer css
import './footer.css';

// Import for the Colley Image in the Footer
import FooterLogo from './colleyLogo.png';

// Imports the Social Media Icons for React Icons
import { FaLinkedin, FaInstagram, FaTwitter } from 'react-icons/fa';

// Imports the routing things from the React Router
import { useNavigate, Link } from 'react-router-dom';

function Footer() {
  let navigate = useNavigate();

  // Footer:

  // - Social medias
  // - Page landing page links
  // - Contacts

  return (
    <footer className="footerContainer">
      <div className="logoAndSocialMediaContainer">
        <img
          className="footerColleyImg"
          src={FooterLogo}
          alt="Colley Logo Image"
        />

        <div className="footerSocialMediaContainer">
          <a
            target="_blank"
            rel="noopener noreferrer"
            href="https://www.linkedin.com/company/getspogo"
          >
            <FaLinkedin
              className="socialIconFooter"
              size={25}
              color={'#FCFBFA'}
            />
          </a>
          <a
            target="_blank"
            rel="noopener noreferrer"
            href="https://twitter.com/getspogo"
          >
            <FaTwitter className="socialIconFooter" size={25} color={'#FCFBFA'} />
          </a>
          <a
            target="_blank"
            rel="noopener noreferrer"
            href="https://www.instagram.com/getspogo/"
          >
            <FaInstagram
              className="socialIconFooter"
              size={25}
              color={'#FCFBFA'}
            />
          </a>
        </div>
      </div>

      {/* divider */}
      <hr color="#FCFBFA" />

      <div className="footerLinksColumnContainer">
        <div className="footerColumnContainer">
          <h4 className="footerColumnHeader">Legal</h4>
          <p className="bottomLinksText">Privacy Policy</p>
          <p className="bottomLinksText">Terms of Service</p>
        </div>
        <div className="footerColumnContainer">
          <h4 className="footerColumnHeader">Contact</h4>
          <p className="bottomLinksText"
            onClick={() => {
              window.open('mailto:getspogo@gmail.com');
            }}
          >
            getcolley@colley.com
          </p>
        </div>
        <div className="footerColumnContainer">
          <h4 className="footerColumnHeader">Pages</h4>
          <Link onClick={() => window.scrollTo(0,0)} to="/" className="bottomLinksText">
            Home
          </Link>
          <Link onClick={() => window.scrollTo(0,0)} to="/about" className="bottomLinksText">
            About
          </Link>
          <Link onClick={() => window.scrollTo(0,0)} to="/blog" className="bottomLinksText">
            Blog
          </Link>
          <Link onClick={() => window.scrollTo(0,0)} to="/faq" className="bottomLinksText">
            FAQ
          </Link>
        </div>
      </div>
    </footer>
  );
}

export default Footer;
