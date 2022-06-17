import { useState, useEffect } from "react";

// Router Imports
import { Link, useLocation, useNavigate } from "react-router-dom";

// CSS import for this header
import "./header.css";

// Colley Logo Import
import HeaderLogo from "./colleyLogo.png";
import SearchIcon from '@mui/icons-material/Search';
import { fetchCollegesOnRender, getColleges } from "../../global";
import CollegeSearchBar from "../CollegeSearchBar/CollegeSearchBar";

// Header:

// - Search bar to search by colleges
// - About page
// - FAQ

//use Link for user navigation
//use navigate to do it yourself (form sumbissions)

function Header( props : {onClick: () => void} ) {
  const navigate = useNavigate();
  const location = useLocation();
  const [colleges, setColleges] = useState<String[]>([]);
  const [windowWidth, setWindowWidth] = useState(getWindowWidth());
  const [hiddenSearchBarActive, setHiddenSearchBarActive] = useState<boolean>(false);

  function getWindowWidth() {
    const { innerWidth: width } = window;
    return width;
  }

  useEffect(() => {
    let allColleges = getColleges();
    collegesNotFetched(allColleges);
  }, []);

  // Listens for changes in the window's width
  useEffect(() => {
    function handleResize() {
      setWindowWidth(getWindowWidth());
    }

    window.addEventListener('resize', handleResize);
    return () => window.removeEventListener('resize', handleResize);
  }, []);

  // Checks to see if this useEffect has triggered before the API call to get
  // all the colleges has finished. If so, makes the API call again and waits
  // until it finished before set colleges.
  async function collegesNotFetched(allColleges: JSON) {
    if (!allColleges) {
      await fetchCollegesOnRender();
      allColleges = getColleges();
    }
    let temp: String[] = [];
    Object(allColleges).forEach((curr: Object) => {
      temp.push(Object(curr)["collegeName"]);
    });
    setColleges(temp);
  }

  return (
    <header className="headerContainer" onClick={props.onClick}>
      <Link to="/">
        <img
          className="headerColleyImg"
          src={HeaderLogo}
          alt="Colley Logo Image"
        />
      </Link>

      {location.pathname === "/" || windowWidth < 1200 ? null : (
          <CollegeSearchBar />
      )}

      <div className="navbarContainer">
        <div className="hiddenNavbarLinks">
          <Link to="/about" className="headerLinkItem">
            About
          </Link>
          <Link to="/blog" className="headerLinkItem">
            Blog
          </Link>
          <Link to="/faq" className="headerLinkItem">
            FAQ
          </Link>
        </div>
        
        {windowWidth < 1200 ? 
          <SearchIcon 
            style={{marginTop: '1px'}} 
            fontSize="medium" 
            className="headerLinkItem"
            // onClick={() => setHiddenSearchBarActive(true)}
            onClick={() => navigate('/')}
          />
          : 
          <><Link to="/about" className="headerLinkItem">
            About
          </Link><Link to="/blog" className="headerLinkItem">
              Blog
            </Link><Link to="/faq" className="headerLinkItem">
              FAQ
            </Link>
          </>
        }

        {/* <div className={hiddenSearchBarActive ? 'hiddenSearchBar active' : 'hiddenSearchBar'}>
          <CollegeSearchBar />
        </div> */}
      </div>
    </header>
  );
}

export default Header;
