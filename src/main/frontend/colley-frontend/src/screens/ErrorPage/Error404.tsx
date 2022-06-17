import React from 'react';
import ErrorImage from './404error.png';
import { Link } from 'react-router-dom';
import './Error404.css';

const Error404: React.VFC = () => {
  return (
    <div className="ErrorPageContainer">
      <img className="errorImage" src={ErrorImage} />
      <Link className="backHomeButtonErrorPage" to="/">
        Back Home
      </Link>
    </div>
  );
};

export default Error404;
