import React, { useState } from "react";

//CSS styles import
import "./review.css";

//Applicant Review Interface
import applicantProfile from "../../interfaces/applicantProfile";

// Modal Import
import FullProfileModal from "../FullProfileModal/FullProfileModal";

// const Review = (props: { review: applicantReview }) => {
//   const review = props.review;
//   let intendedMajor = review.getIntendedMajor;
//   let GPA = review.getGPA;
//   let outcome = review.getOutcome == 1 ? "Accepted" : "Rejected";

// This component represents a Application Review / Profile.

const Review = ({ profile }: { profile: applicantProfile }) => {
  const GPA = profile.getGPA.toFixed(2);
  const SAT = profile.getSAT < 0 ? "N/A" : profile.getSAT;
  const ACT = profile.getACT < 0 ? "N/A" : profile.getACT;

  // React State Variables
  const [refresh, setRefresh] = useState<boolean>(false);

  // This is for opening the modal when you want to see the full profile.
  const [modalOpen, setModalOpen] = useState<boolean>(false);

  return (
    <div className="reviewContainer">
      <FullProfileModal refresh={refresh} open={modalOpen} profile={profile} />
      <div>
        <div className="reviewContainerTopRow">
          {profile.getOutcome === 1 ? (
            <div className="decisionContainer"> Accepted ✅</div>
          ) : (
            <div className="decisionContainer"> Rejected ❌</div>
          )}
          <div className="classContainer">Class of {profile.getClassOf}</div>
        </div>
        <div className="statisticsAdviceContainer">
          <div className="reviewItemStatisticsContainer">
            {/* Column */}
            <p className="reviewStatItem">GPA: {GPA}</p>
            <p className="reviewStatItem">SAT: {SAT}</p>
            <p className="reviewStatItem">ACT: {ACT}</p>
            <p className="reviewStatItem">Major: {profile.getIntendedMajor}</p>
          </div>
          <div className="reviewItemAdviceContainer">
            <div className="reviewStatItem">Advice:</div>
            <div className="reviewStatItem">{profile.getAdvice}</div>
          </div>
        </div>
      </div>

      <div className="fullProfileButtonContainer">
        <button
          onClick={() => {
            setRefresh(!refresh);
            setModalOpen(true);
          }}
        >
          Click to view full profile!
        </button>
      </div>

      {/* Advice */}
      {/* Click to view full profile */}
    </div>
  );
};

export default Review;
