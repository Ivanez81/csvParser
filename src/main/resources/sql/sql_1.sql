SELECT DISTINCT s.ssoid FROM public.ssdb_final AS s WHERE s.ts BETWEEN 1499812078 AND 1499815678;

SELECT s.ssoid, s.ts, s.formid FROM public.ssdb_final AS s WHERE s.ts BETWEEN 1499812078 AND 1499815678;

SELECT s.ssoid, s.ts, s.formid FROM public.ssdb_final AS s WHERE s.ssoid IN 
(SELECT DISTINCT s.ssoid FROM public.ssdb_final AS s WHERE s.ts BETWEEN 1499812078 AND 1499815678);

SELECT s.formid, COUNT(s.formid) FROM public.ssdb_final AS s GROUP BY s.formid ORDER BY COUNT(s.formid) DESC;


SELECT s.ssoid, s.ts, s.grp, s.subtype, s.formid FROM public.ssdb_final AS s WHERE s.grp LIKE 'dszn_%' ORDER BY s.ssoid, s.ts;


SELECT DISTINCT s.ssoid FROM public.ssdb_final AS s WHERE s.grp LIKE 'dszn_%' ORDER BY s.ssoid;

SELECT s.ssoid, s.ts, s.grp, s.subtype, s.formid FROM public.ssdb_final AS s WHERE s.grp LIKE 'dszn_%' AND s.ssoid = '0079acfc-d25e-4fba-b5c8-8c15bb7eb7cb' ORDER BY s.ts DESC LIMIT 1;