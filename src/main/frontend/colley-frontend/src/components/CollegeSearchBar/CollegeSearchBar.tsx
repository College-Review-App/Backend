// Material UI Components
import { Autocomplete, TextField } from "@mui/material";
import { useState, useEffect } from "react";

// Import for React Router
import { useLocation, useNavigate } from "react-router-dom";
import { fetchCollegesOnRender, getColleges } from "../../global";

// Import CSS 
import './CollegeSearchBar.css';

// Component the represents the college search bar
const CollegeSearchBar = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const [colleges, setColleges] = useState<String[]>([]);

  useEffect(() => {
    let allColleges = getColleges();
    collegesNotFetched(allColleges);
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
    <Autocomplete
      className="collegeSearchBar"
      disablePortal
      onChange={(e) => {
        const element = e.target as HTMLInputElement;
        const value = element.innerHTML;
        if (value.length > 4 && value.length < 50) {
          navigate(`./colleges/${value}`);
        }
      }}
      id="combo-box-demo"
      options={colleges}
      noOptionsText={
        <p 
          className="addCollegeOption"
          onClick={() => navigate("./add-college")}
        >Add new college</p>
      }
      // sx={{ width: "50%", height: "10" }}
      renderInput={(params) => (
        <TextField {...params} label="Search for a college" variant={location.pathname === '/' ? "filled" : "outlined"} />
      )}
    />
  );
};

export default CollegeSearchBar;
