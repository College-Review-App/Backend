import './HomePage.css';

// Landing Page Graphics Images
import PrivacyFeatureGraphic from './images/PrivacyFeatureGraphic.png';
import VisibilityFeatureGraphic from './images/VisibilityFeatureGraphic.png';
import InsightsFeatureGraphic from './images/InsightsFeatureGraphic.png';

// College Image Imports
import StanfordLogo from './images/stanford.png';
import UniversityOfWashingtonLogo from './images/UniversityOfWashington.png';
import UniversityOfMichiganLogo from './images/UniversityofMichigan.png';
import UCBerkeleyLogo from './images/UCBerkeley.png';
import GeorgiaTechLogo from './images/GeorgiaTech.png';
import CollegeSearchBar from '../../components/CollegeSearchBar/CollegeSearchBar';

function HomePage() {

  return (
    <div className='landingPageContainer'>
      <div className="landingPageSearchBarContainer">
        <CollegeSearchBar />
      </div>
      <div className='featuredCollegesGreyRowContainer'>
        {/* could do "Colleges you know and love, all on Colley." */}
        <div className="featuredCollegesGreyRowHeader">Hundreds of Colleges all on Colley</div> 
        <div className='featuredCollegesGreyRowCollegesContainer'>
          <img className='featuredCollegesLogo' src={GeorgiaTechLogo} alt={"Georgia Tech Logo"}/>
          <img className='featuredCollegesLogo' src={StanfordLogo} alt={"Stanford Logo"}/>
          <img className='featuredCollegesLogo' src={UCBerkeleyLogo} alt={"UC Berkeley Logo"}/>
          <img className='featuredCollegesLogo' src={UniversityOfMichiganLogo} alt={"University of Michigan Logo"}/>
          <img className='featuredCollegesLogo' src={UniversityOfWashingtonLogo} alt={"University of Washington Logo"}/>
        </div>
      </div>
      <div className="landingPageFeatureGraphicsHeadline">
        <h1>What we offer</h1>
      </div>
      <div className='landingPageFeatureGraphicsContainer'>
        <div className='featureGraphicContainer'>
          <img src={InsightsFeatureGraphic} alt={"Insights Feature Graphic"}/>
          <h1>Unrivaled Insights</h1>
          <p>
            Unlock the information and advice you need to get accepted into
            the college of your dreams.
          </p>
        </div>
        <div className='featureGraphicContainer'>
          <img src={VisibilityFeatureGraphic} alt={"Visibility Feature Graphic"}/>
          <h1>Increased Visibility</h1>
          <p>
            View verified data on past applications to top colleges around the
            country.
          </p>
        </div>
        <div className='featureGraphicContainer'>
          <img src={PrivacyFeatureGraphic} alt={"Privacy Feature Graphic"}/>
          <h1>Crowdsourcing, with Privacy</h1>
          <p>
            Add your own college application experiences to help out other
            students, while maintaining complete privacy.
          </p>
        </div>
        
      </div>
    </div>
  );
}

export default HomePage;
